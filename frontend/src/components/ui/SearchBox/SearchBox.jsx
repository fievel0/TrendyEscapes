import LoginForm from "../../forms/LoginForm";
import RegisterForm from "../../forms/RegisterForm";
import { Link } from "react-router-dom";
import Modal from "../../ui/Modal/Modal";
import { useState } from "react";

/* eslint-disable react/no-unknown-property */
const SearchBox = () => {
  const [login, setLogin] = useState(false);
  const [register, setRegister] = useState(false);

  

  const [loginAccept, setLoginAccept] = useState(false);
  const [registerAccept, setRegisterAccept] = useState(false);

  const [pais, setPais] = useState("United%20States");

  const handlePais = (e) => {
    setPais(e.target.value);
  };

  const handleLoginForm = () => {
    setLogin(!login);
  };

  const handleRegisterForm = async () => {
    setLogin(false);
    setRegister(!register);
  };

  const hangleRegister =  () => {
    setRegisterAccept(true);  
    setLogin(false);
    setRegister(false); 
  };


  const hangleLogin = async () => {
    setLoginAccept(true);
    setLogin(false);    
  };


  return (
    <>
      {loginAccept && (
        <Modal
          message="Usuario Logueado con exito"
          foo={() => setLoginAccept(false)}
          fooMsg="Aceptar"
        />
      )}

      {registerAccept && (
        <Modal
          message="Usuario Creado con exito"
          foo={() => setRegisterAccept(false)}
          fooMsg="Aceptar"
        />
      )}
      <div className="bg-white h-20 mx-auto mobile:h-14 w-[411px] mobile:w-auto mobile:mx-4 px-5 rounded-3xl flex items-center justify-between">
        {/* <input type="text" className="bg-white focus:bg-white focus:outline-none mobile:w-[180px]" /> */}
        <select name="pais" id="pais" className="w-full" onChange={handlePais}>
          <option value="United%20States">United States</option>
          <option value="Brazil">Brazil</option>
          <option value="Spain">Spain</option>
          <option value="France">France</option>
          <option value="Maldives">Maldives</option>
          <option value="Morocco">Morocco</option>
          <option value="Mexico">Mexico</option>
          <option value="Chile">Chile</option>
          <option value="Japan">Japan</option>
          <option value="Ecuador">Ecuador</option>
          <option value="Tanzania">Tanzania</option>
          <option value="Thailand">Thailand</option>
          <option value="Greece">Greece</option>
          <option value="Italy">Italy</option>
          <option value="Egypt">Egypt</option>
          <option value="Switzerland">Switzerland</option>
          <option value="South%20Africa">South Africa</option>
        </select>
        <Link
          to={`/search/${pais}`}
          className="h-14 w-14 mobile:h-10 mobile:w-10 bg-primary rounded-2xl text-3xl flex justify-center items-center pb-[6px]"
        >
          <img
            src="./Images/search.svg"
            alt="search icon"
            className="p-2 pt-3 object-contain"
          />
        </Link>
        <div
          className="absolute top-10 right-10 mobile:top-3 mobile:right-3 cursor-pointer"
          onClick={handleLoginForm}
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="48"
            height="48"
            viewBox="0 0 24 24"
            fill="none"
            stroke="#FF9500"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="icon icon-tabler icons-tabler-outline icon-tabler-user-circle"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
            <path d="M12 12m-9 0a9 9 0 1 0 18 0a9 9 0 1 0 -18 0" />
            <path d="M12 10m-3 0a3 3 0 1 0 6 0a3 3 0 1 0 -6 0" />
            <path d="M6.168 18.849a4 4 0 0 1 3.832 -2.849h4a4 4 0 0 1 3.834 2.855" />
          </svg>
        </div>
      </div>
      {login && (
        <LoginForm
          registerBtn={true}
          cancelFoo={handleLoginForm}
          registerFoo={handleRegisterForm}
          hangleLogin={hangleLogin}
        />
      )}
      {register && (
        <RegisterForm
          cancelFoo={handleRegisterForm}
          hangleRegister={hangleRegister}
        />
      )}
    </>
  );
};
export default SearchBox;
