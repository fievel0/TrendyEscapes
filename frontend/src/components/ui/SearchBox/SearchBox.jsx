import { useState } from "react"
import LoginForm from "../../forms/LoginForm"
import RegisterForm from "../../forms/RegisterForm"

/* eslint-disable react/no-unknown-property */
const SearchBox = () => {
    const [login, setLogin] = useState(false)
    const [register, setRegister] = useState(false)

    const handleLoginForm = () => {        
        setLogin(!login)
    }

    const handleRegisterForm = () => {
        setLogin(false)
        setRegister(!register)
    }

    const hangleLogin = (user) => {
        handleLoginForm()
        console.log(user)
    }

    const hangleRegister = (user) => {
        handleRegisterForm()
        console.log(user)
    }


    return (
    <>
        <div className="bg-white h-20 mobile:h-14 w-[411px] mobile:w-auto mobile:mx-4 px-5 rounded-3xl flex items-center justify-between">
            <img src="./Images/search.svg" alt="search icon"/>
            <input type="text" className="bg-white focus:bg-white focus:outline-none mobile:w-[180px]" />
            <button className="h-14 w-14 mobile:h-10 mobile:w-10 bg-primary rounded-2xl text-3xl flex flex-wrap justify-center items-center pb-[6px]">+</button>
            <div className="absolute top-10 right-10 mobile:top-3 mobile:right-3 cursor-pointer" onClick={handleLoginForm}>
                <svg  xmlns="http://www.w3.org/2000/svg"  width="48"  height="48"  viewBox="0 0 24 24"  fill="none"  stroke="#FF9500"  stroke-width="2"  stroke-linecap="round"  stroke-linejoin="round"  class="icon icon-tabler icons-tabler-outline icon-tabler-user-circle"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M12 12m-9 0a9 9 0 1 0 18 0a9 9 0 1 0 -18 0" /><path d="M12 10m-3 0a3 3 0 1 0 6 0a3 3 0 1 0 -6 0" /><path d="M6.168 18.849a4 4 0 0 1 3.832 -2.849h4a4 4 0 0 1 3.834 2.855" /></svg>
            </div>
        </div>
        {login && <LoginForm registerBtn={true} cancelFoo={handleLoginForm} registerFoo={handleRegisterForm} loginFoo={hangleLogin} />}
        {register && <RegisterForm cancelFoo={handleRegisterForm} registerFoo={hangleRegister}/>}
    </>

    )
}
export default SearchBox