import { createContext, useState } from "react";
import axios from "axios";

const UserContext = createContext();

const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null)

  const loginFoo = (email, password) => {   
    axios.post("http://localhost:8080/auth/login", {
        email: email,
        password: password
      })
      .then((res) => {          
          console.log("🚀 ~ .then ~ status:", res.status)
        if (res.status === 200) {
          setUser(res.data.email);
          //guardar el jwt en local storage
          localStorage.setItem("token", res.data.token);
          console.log('data', res.data.token);         
          
        } else {
          console.log(res.data);
        }
      })
      .catch((error) => {
        console.log('errooooor', error);
      })
  };

  const registerFoo = (user) => {
    axios.post("http://localhost:8080/auth/register", user)
      .then((res) => {
        if (res.status === 201) {
          return res.data;
        } else {
          console.log(res.data);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const data = {
    user,
    loginFoo,
    registerFoo,
  };

  

  return (
    <UserContext.Provider value={data}>
      {children}
    </UserContext.Provider>
  );
};

export {UserProvider}
export default UserContext