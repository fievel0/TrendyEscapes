import { useState } from "react"

const LoginForm = ({loginFoo, registerFoo, cancelFoo, registerBtn}) => {
    const [user, setUser] = useState({
		email: '',		
		password: '',
	})

	const handleChange = (e) => {
		setUser({
			...user,
			[e.target.name]: e.target.value        
		})   
	}

	const handleSubmit = (e) => {
		e.preventDefault();
		loginFoo(user);
	}

  return (
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50 backdrop-blur-sm z-50 flex items-center justify-center p-4">
			<form className="flex flex-col max-w-[500px] min-w-[550px] mobile:min-w-[300px] bg-white p-10 rounded-lg shadow-md" onSubmit={handleSubmit}>
				<legend className="font-bold text-2xl mb-4">Login</legend>				
				<div>
					<label htmlFor="email" className='block mb-2'>Email</label>
					<input type="email" id="email" name="email" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Email" required onChange={handleChange}/>
				</div>

				<div>
					<label htmlFor="password" className='block mb-2'>Contraseña</label>
					<input type="password" id="password" name="password" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Contraseña" required onChange={handleChange}/>				
				</div>				

				<div className="gap-2 flex flex-wrap">
					<button className={`bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg ${registerBtn ? 'w-[calc(50%-4px)]' : 'w-full'}`} type="submit">Login</button>
					<button className={`bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg ${registerBtn ? 'w-[calc(50%-4px)]' : 'w-full'}`}  onClick={cancelFoo}>Cancelar</button>
					{registerBtn && <button className="w-full bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg" onClick={registerFoo}>Registrarse</button>}
				</div>
				
				
			</form>
		</div>
  )
}
export default LoginForm