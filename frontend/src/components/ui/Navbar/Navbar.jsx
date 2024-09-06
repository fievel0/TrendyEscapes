import { useState , useEffect } from "react";
import { MdOutlineTravelExplore } from "react-icons/md";
import LoginForm from "../../forms/LoginForm";
import RegisterForm from "../../forms/RegisterForm";
import { Link } from "react-router-dom";
import { useLocation } from 'react-router-dom';
import MobileMenu from "./MobileMenu";


const Navbar = () => {
    const [isHome, setIsHome] = useState(null)
    const [showMenu, setShowMenu] = useState(true)

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

    const closeMenu = () => {
        setShowMenu(false)
    }



    return (
        <>
            <header className={isHome ? 'hidden' :"bg-white"}>
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
                    <div className='lg:flex lg:gap-x-12 hidden'>
                        <a href="#" className="text-sm font-semibold leading-6 text-gray-900">
                            Comunidad
                        </a>
                        <a href="#" className="text-sm font-semibold leading-6 text-gray-900">
                            Paquetes
                        </a>
                        <a href="#" className="text-sm font-semibold leading-6 text-gray-900">
                            Contacto
                        </a>
                    </div>
                    <div className="hidden lg:flex lg:flex-1 lg:justify-end">
                        <div className="flex space-x-2">
                            <button className="bg-secundary rounded-xl p-2 text-gray-900 hover:bg-primary hover:text-gray-700 transition duration-300 ease-in-out" onClick={handleLoginForm}>
                                Log in
                            </button>
                            <button className="bg-primary rounded-xl p-2 text-gray-900 hover:bg-white hover:text-gray-700 transition duration-300 ease-in-out" onClick={handleRegisterForm}>
                                Register <span aria-hidden="true">&rarr;</span>
                            </button>
                        </div>
                    </div>
                    {showMenu && <MobileMenu closeMenu={closeMenu} login={handleLoginForm} register={handleRegisterForm}/>}
                </nav>
            </header>


            {login && <LoginForm loginFoo={hangleLogin} cancelFoo={handleLoginForm} />}
            {register && <RegisterForm cancelFoo={hangleRegister} />}

        </>
    );
};

export default Navbar;
