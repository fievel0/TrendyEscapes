import { useState } from "react"

const RegisterForm = ({cancelFoo, registerFoo}) => {
	const [user, setUser] = useState({
		name: '',
		email: '',
		phone: '',	
		date: '',
		document: '',
		country: '',
		city: '',
		address: '',
		password: '',
		confirmPassword: ''
	})

	const handleChange = (e) => {
		setUser({
			...user,
			[e.target.name]: e.target.value        
		})   
	}

	const handleSubmit = (e) => {
		e.preventDefault();
		registerFoo(user)
	}	

	return (
		<div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50 backdrop-blur-sm z-50 flex items-center justify-center p-4">
			<form className="flex flex-col max-w-[500px] min-w-[550px] mobile:min-w-[300px] bg-white p-10 rounded-lg shadow-md" onSubmit={handleSubmit}>
				<legend className="font-bold text-2xl mb-4">Registro</legend>
				<div>
					<label htmlFor="name" className='block mb-2'>Nombre Completo</label>
					<input type="text" id="name" name='name' className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Nombre" required onChange={handleChange}/>
				</div>
				<div className="flex gap-4">
					<div className="w-1/2">
						<label htmlFor="email" className='block mb-2'>Email</label>
						<input type="email" id="email" name="email" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Email" required onChange={handleChange}/>
					</div>
					<div className="w-1/2">
						<label htmlFor="phone" className='block mb-2'>Telefono</label>
						<input type="text" id="phone" name="phone" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Telefono" required onChange={handleChange}/>
					</div>
				</div>

				<div className="flex gap-4">
					<div className="w-1/2">
						<label htmlFor="date" className='block mb-2'>Fecha de Nacimiento</label>
						<input type="date" id="date" name="date" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' required onChange={handleChange}/>
					</div>
					<div className="w-1/2">
						<label htmlFor="document" className='block mb-2'>Número de documento</label>
						<input type="text" id="document" name="document" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Número de documento" required onChange={handleChange}/>
					</div>
				</div>

				<div className="flex gap-4">
					<div className="w-1/2">
						<label htmlFor="country" className='block mb-2'>Pais</label>
						<input type="text" id="country" name="country" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Pais" required onChange={handleChange}/>
					</div>
					<div className="w-1/2">
						<label htmlFor="city" className='block mb-2'>Ciudad</label>
						<input type="text" id="city" name="city" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Ciudad" required onChange={handleChange}/>
					</div>
				</div>


				<div>
					<label htmlFor="address" className='block mb-2'>Dirección</label>
					<input type="text" id="address" name="address" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Dirección" required onChange={handleChange}/>				
				</div>

				<div className="flex gap-4 mb-4">
					<div className="w-1/2">
						<label htmlFor="password" className='block mb-2'>Contraseña</label>
						<input type="password" id="password" name="password" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Contraseña" required onChange={handleChange}/>				
					</div>
					<div className="w-1/2">	
						<label htmlFor="repeatPassword" className='block mb-2'>Repetir Contraseña</label>
						<input type="password" id="repeatPassword" name="repeatPassword" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Repetir Contraseña" required onChange={handleChange}/>				
					</div>
				</div>


				<div className="flex w-full gap-4">
					<button className="w-1/2 bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg" type="submit">REGISTRAR</button>
					<button className="w-1/2 bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg" onClick={cancelFoo}>CANCELAR</button>
				</div>
			</form>
		</div>
	)
}
export default RegisterForm
