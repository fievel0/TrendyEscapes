import './Footer.css'

const Footer = () => {
    
  return (
    <footer className="w-screen flex flex-col items-start justify-center gap-4 py-5 border-t border-t-gray-400">
        <div className='w-screen flex mobile:flex-col items-start mobile:items-center justify-evenly mb-6'>
            <div className="w-[230px] mobile:w-[250px] mobile:mb-10 flex-col content-around justify-center ">
                <h3 className="text-xl  text-primary mb-3">Trendy Escapes</h3>
                <p>Descubre experiencias únicas en tus vacaciones de verano, ya sea en la naturaleza exuberante, ciudades vibrantes o playas paradisíacas</p>
            </div>

            <div className="w-[150px] mobile:w-[250px] mobile:mb-10 flex flex-col items-start content-center justify-center ">
                <h3 className="text-xl  text-primary mb-3">Enlaces Rápidos</h3>
                <a href="/">Home</a>
                <a href="/">Paquetes</a>
                <a href="/contact">Contacto</a>
                <a href="/">Comunidad</a>
            </div>

            <div className="w-[230px] mobile:w-[250px] mobile:mb-10 flex flex-col items-start content-around justify-center border-solid">
                <h3 className="text-xl  text-primary mb-3">Contacto</h3>
                <div className="flex flex-wrap content-around justify-start gap-2">
                    <img src="../Icons/location.svg" alt="icono de ubicación" className='w-8 h-8 footerIcon' />
                    <p>Avenida Siempreviva 742</p>
                </div>
                <div className="flex flex-wrap content-around justify-start gap-2">
                    <img src="../Icons/phone.svg" alt="icono de telefono" className='w-8 h-8 footerIcon' />
                    <p>+54 9 351 211 211</p>
                </div>
                <div className="flex flex-wrap content-around justify-start gap-2">
                    <img src="../Icons/mail.svg" alt="icono de mail" className='w-8 h-8 footerIcon' />
                    <p>trendyescapes@gmail.com</p>
                </div>            
            </div>

            <div className="w-[140px] mobile:w-[250px] mobile:mb-10 flex flex-col items-start content-around justify-center ">
                <h3 className="text-xl  text-primary mb-3">Siguenos</h3>
                <div className='flex flex-wrap content-around justify-start gap-4'>
                    <a href="/"><img src="../Icons/facebook.svg" alt="icono de facebook" className='w-8 h-8 footerIcon' /></a>
                    <a href="/"><img src="../Icons/instagram.svg" alt="icono de instagram" className='w-8 h-8 footerIcon' /></a>
                    <a href="/"><img src="../Icons/x.svg" alt="icono de x" className='w-8 h-8 footerIcon' /></a>
                </div>            
            </div>
        </div>
        <div className='w-[95%] m-auto border-solid border-t border-t-gray-400 mb-6'></div>
        <p className=' w-full text-center'>© 2024 Trendy Escapes. Todos los derechos reservados.</p>
    </footer>
  )
}

export default Footer