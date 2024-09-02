import { Link } from "react-router-dom"


const ContactModal = () => {
  return ( 
        
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50">
        <div className='m-auto relative top-[25%] w-[900px] tablet:w-11/12 bg-white p-10 flex flex-col rounded-lg'>
            <p className='text-center text-3xl mb-4'>¡El mensaje fue enviado con exito!</p>
            <button className="w-[200px] m-auto py-2 px-4 border border-solid rounded-lg bg-gray-800 text-white">
              <Link to='/'>Volver a Home</Link>
            </button>
        </div>
    </div>

  )
}

export default ContactModal