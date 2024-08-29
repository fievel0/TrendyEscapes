import { useState } from "react"


const ContactForm = () => {

    const [user, setuser] = useState({
        name: '',
        email: '',
        message: ''
    })

    const handleChange = (e) => {
        setuser({
            ...user,
            [e.target.name]: e.target.value
        })
    }

    const handleSubmit = (e) => {   
        e.preventDefault()
        console.log(user)
    }


  return (    
    <form className="w-[900px] m-auto border-solid rounded-lg border-2 border-gray-200 p-4" onSubmit={handleSubmit}>
        <div>
            <label htmlFor="name" className='block text-lg mb-2'>Nombre</label>
            <input type="text" id="name" name='name' className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Nombre" onChange={handleChange}/>
        </div>

        <div>
            <label htmlFor="email" className='block text-lg mb-2'>Email</label>
            <input type="email" id="email" name="email" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Email" onChange={handleChange}/>
        </div>

        <div>
            <label htmlFor="message" className='block text-lg mb-2'>Mensaje</label>
            <textarea id="message" name='message' className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Mensaje" onChange={handleChange}></textarea>
        </div>

        <button className="w-full text-lg border-solid border border-gray-900 rounded-lg bg-gray-900 text-slate-200 py-1" type="submit">Enviar</button>
    </form>
  )
}

export default ContactForm