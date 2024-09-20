import { useState , useEffect, useContext } from "react";
import { MdOutlineTravelExplore } from "react-icons/md";
import LoginForm from "../../forms/LoginForm";
import RegisterForm from "../../forms/RegisterForm";
import { Link } from "react-router-dom";
import { useLocation } from 'react-router-dom';
import MobileMenu from "./MobileMenu";
import Modal from "../../ui/Modal/Modal";
import UserContext from "../../../context/userContext";


const Navbar = () => {
    const [isHome, setIsHome] = useState(null)
    const [showMenu, setShowMenu] = useState(false)
    const { user, logOut } = useContext(UserContext);

    /* esconder el footer en home */
    const location = useLocation();
    useEffect(() => {
        if (location.pathname === '/') {
            setIsHome(true)
        } else {
            setIsHome(false)
        }
    }, [location.pathname]) 


    const [login, setLogin] = useState(false)
    const [register, setRegister] = useState(false)

    const [loginAccept, setLoginAccept] = useState(false);
    const [registerAccept, setRegisterAccept] = useState(false);
    const [userModal, setUserModal] = useState(false);

    const handleLoginForm = () => {
        setLogin(!login)
    }

    const handleRegisterForm = () => {
        setLogin(false)
        setRegister(!register)
    }

    const hangleLogin = () => {
        setLoginAccept(true)
        setLogin(false)
    }

    const hangleRegister = () => {
        setRegisterAccept(true)
        setRegister(false)
    }

    const closeMenu = () => {
        setShowMenu(false)
    }

    const hangleLogOut = () => {
        setUserModal(false)
        logOut()
    }




    return (
        <>
            {loginAccept && <Modal message="Login exitoso" foo={() => setLoginAccept(false)} fooMsg="Aceptar"/>}
            {registerAccept && <Modal message="Registro exitoso" foo={() => setRegisterAccept(false)} fooMsg="Aceptar"/>}   
            {userModal && <Modal message={`Bienvenido ${user}`} foo={() => setUserModal(false)} fooMsg="Aceptar" fooB={hangleLogOut} fooBMsg="Cerrar Sesión"/>}
            <header className={isHome ? 'hidden' :"bg-white shadow-lg"}>
                <nav
                    className="mx-auto flex max-w-7xl items-center justify-between p-6 lg:px-8"
                    aria-label="Global"
                >
                    <div className="flex lg:flex-1">
                        <Link to="/" className="-m-1.5 p-1.5">
                            <span className="sr-only">Your Company</span>
                            <MdOutlineTravelExplore className="h-8 w-auto" />
                        </Link>
                    </div>
                    <div className='flex lg:hidden' onClick={() => setShowMenu(!showMenu)}>
                        <button type="button" className="-m-2.5 inline-flex items-center justify-center rounded-md p-2.5 text-gray-700">
                            <span className="sr-only">Open main menu</span>
                            <svg
                                className="h-6 w-6"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                aria-hidden="true"
                            >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"
                                />
                            </svg>
                        </button>
                    </div>
                    <div className='lg:flex lg:gap-x-12 hidden [&>*]:rounded-md [&>*]:py-2 [&>*]:px-4 [&>*]:border [&>*]:border-white hover:[&>*]:border-primary '>
                        <Link  to="/" className="text-sm font-semibold leading-6 text-gray-900">
                            Comunidad
                        </Link>
                        <Link to="/packages" className="text-sm font-semibold leading-6 text-gray-900">
                            Paquetes
                        </Link>
                        <Link to="/contact" className="text-sm font-semibold leading-6 text-gray-900">
                            Contacto
                        </Link>
                    </div>
                    <div className="hidden lg:flex lg:flex-1 lg:justify-end">
                        {user ? 
                        <p className="border border-solid rounded-lg p-2 cursor-pointer hover:shadow-lg transition" onClick={() => setUserModal(true)}>Bienvenido {user}</p> :
                        <div className="flex space-x-2">
                            <button className="bg-secundary rounded-xl p-2 text-gray-900 hover:bg-primary hover:text-gray-700 transition duration-300 ease-in-out" onClick={handleLoginForm}>
                                Log in
                            </button>
                            <button className="bg-primary rounded-xl p-2 text-gray-900 hover:bg-white hover:text-gray-700 transition duration-300 ease-in-out" onClick={handleRegisterForm}>
                                Register <span aria-hidden="true">&rarr;</span>
                            </button>
                        </div> }
                    </div>
                    {showMenu && <MobileMenu closeMenu={closeMenu} login={handleLoginForm} register={handleRegisterForm}/>}
                </nav>
            </header>


            {login && <LoginForm hangleLogin={hangleLogin} cancelFoo={handleLoginForm} />}
            {register && <RegisterForm hangleRegister={hangleRegister} cancelFoo={handleRegisterForm}  />}

        </>
    );
};

export default Navbar;
