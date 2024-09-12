import { useEffect, useState } from "react"
import { Link } from "react-router-dom"

const MobileMenu = ({closeMenu, login, register}) => {
    const [position, setPosition] = useState('top-[-200%]')

    useEffect(() => {
        setPosition('top-20')        
    }, [])

  return (
    <div className={`${position} duration-300 absolute left-1/2 translate-x-[-50%] w-11/12 rounded-b-2xl py-4 bg-gray-50 shadow-lg`}>
        <ul className="flex flex-col gap-y-4 [&>*]:border-b  px-6 ">
            <p onClick={login}>Login</p> 
            <p onClick={register}>Register</p>         
            <Link to='/' onClick={closeMenu}>Comunidad</Link>
            <Link to='/packages' onClick={closeMenu}>Paquetes</Link>
            <Link to='/contact' onClick={closeMenu}>Contacto</Link>
        </ul>
    </div>
  )
}
export default MobileMenu