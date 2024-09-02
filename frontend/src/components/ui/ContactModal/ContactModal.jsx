

const ContactModal = () => {
  return ( 
        
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50">
        <div className='m-auto relative top-[25%] w-[900px] bg-white p-10 flex flex-col rounded-lg'>
            <p className='text-center text-3xl mb-4'>¡El mensaje fue enviado con exito!</p>
            <button className="w-[200px] m-auto p-4 border border-solid rounded-lg bg-primary text-white">Cerrar</button>
        </div>
    </div>

  )
}

export default ContactModal