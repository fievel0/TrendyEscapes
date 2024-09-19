import { createContext, useEffect, useState } from "react";
import axios from "axios";
import { BASEURL } from "../config/config";

const UserContext = createContext();

const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null)

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (token) {
           const decodeToken = JSON.parse(atob(token.split(".")[1]));   
           setUser(decodeToken.sub);
    }
  }, []);

  const loginFoo = async (email, password) => {  
    try {
      const res = await axios.post(`${BASEURL}/auth/login`, {
        email: email,
        password: password
      })
      if (res.status === 200) {
        setUser(res.data.email);
        //guardar el jwt en local storage
        localStorage.setItem("token", res.data.jwt);
        /* console.log('data', res.data.jwt); */   
        return (res.status);      
      } else {          
        console.log("🚀 ~ .then ~ res:", res.data)
        throw new Error(res.data);
      }
    } catch (error) {
      console.log("🚀 ~ loginFoo ~ error:", error)
      return (error);
    } 
  }
    

  const registerFoo = async (user) => {
    console.log("🚀 ~ registerFoo ~ user:", user)

    try {
      const res = await axios.post(`${BASEURL}/auth/register`, user)      
      if (res.status === 201) {
        return (res);
      } else {        
        console.log("🚀 ~ registerFoo ~ data:", res.data)
        throw new Error(res.data);
      }
    } catch (error) {      
      console.log("🚀 ~ registerFoo ~ error:", error.response.data)      
      return (error.response.data);
    }
  }

  const logOut = () => {
    setUser(null);
    localStorage.removeItem("token");
  };
   

  const data = {
    user,
    loginFoo,
    registerFoo,
    logOut
  };

  

  return (
    <UserContext.Provider value={data}>
      {children}
    </UserContext.Provider>
  );
};

export {UserProvider}
export default UserContext