import { useContext, useState } from "react"
import UserContext from "../../context/userContext";

const RegisterForm = ({cancelFoo, hangleRegister}) => {
	const { registerFoo } = useContext(UserContext);

	const [user, setUser] = useState({
		nombre: '',
		email: '',
		telefono: '',	
		fechaNacimiento: '',
		documento: '',
		pais: '',
		direccion: '',
		password: '',
		repeatPassword: ''
	})

	const [errorsForms, setErrors] = useState({});

	const handleChange = (e) => {
		setUser({
			...user,
			[e.target.name]: e.target.value        
		})   
	}

	const handleSubmit = async (e) => {
		e.preventDefault();
		const newUser = {...user, autenticacion: {email: user.email, password: user.password}};
		if (user.password !== user.repeatPassword) {
			setErrors({ repeatPassword: "Las contraseñas no coinciden" });
			return;
		}
		try {
			const res = await registerFoo(newUser);
			if (res.status === 201) {
				hangleRegister();		  
			} else {
			  console.log("🚀 ~ hangleRegister ~ res:", res)
			  setErrors(res)
			  console.log("🚀 ~ handleSubmit ~ setErrors:", errorsForms)
			}   
		  } catch (error) {
			console.log("🚀 ~ hangleRegister ~ error:", error)
			alert("Error al registrar usuario");      ;
		  }
	}	

	return (
		<div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50 backdrop-blur-sm z-50 flex items-center justify-center mobile:items-start p-4 overflow-x-scroll">
			<form className="flex flex-col gap-8 max-w-[500px] min-w-[550px] mobile:min-w-[300px] bg-white p-10 rounded-lg shadow-md relative" onSubmit={handleSubmit}>
				<legend className="font-bold text-2xl">Registro</legend>
				<div className=" relative">
					<label htmlFor="nombre" className='block mb-2'>Nombre Completo</label>
					<input type="text" id="nombre" name='nombre' className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Nombre" required onChange={handleChange}/>
					{errorsForms.nombre && <p className="absolute w-full text-red-500 text-xs">{errorsForms.nombre}</p>}
				</div>
				<div className="flex gap-4 mobile:flex-col mobile:gap-0  ">
					<div className="w-1/2 mobile:w-full relative">
						<label htmlFor="email" className='block mb-2'>Email</label>
						<input type="email" id="email" name="email" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Email" required onChange={handleChange}/>
						{errorsForms.email && <p className="absolute w-full text-red-500 text-xs">{errorsForms.email}</p>}
					</div>
					<div className="w-1/2 mobile:w-full  relative">
						<label htmlFor="telefono" className='block mb-2'>Telefono</label>
						<input type="text" id="telefono" name="telefono" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Telefono" required onChange={handleChange}/>
						{errorsForms.telefono && <p className="absolute w-full text-red-500 text-xs">{errorsForms.telefono}</p>}
					</div>
				</div>

				<div className="flex gap-4 mobile:flex-col mobile:gap-0 ">
					<div className="w-1/2 mobile:w-full relative">
						<label htmlFor="fechaNacimiento" className='block mb-2'>Fecha de Nacimiento</label>
						<input type="date" id="fechaNacimiento" name="fechaNacimiento" className='w-full border-solid border rounded-lg px-2 py-2' required onChange={handleChange}/>
						{errorsForms.fechaNacimiento && <p className="absolute w-full text-red-500 text-xs">{errorsForms.fechaNacimiento}</p>}
					</div>
					<div className="w-1/2 mobile:w-full relative">
						<label htmlFor="documento" className='block mb-2'>Número de documento</label>
						<input type="text" id="documento" name="documento" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Número de documento" required onChange={handleChange}/>
						{errorsForms.documento && <p className="absolute w-full text-red-500 text-xs">{errorsForms.documento}</p>}
					</div>
				</div>
				
				<div className=" relative">
					<label htmlFor="pais" className='block mb-2'>Pais</label>
					<input type="text" id="pais" name="pais" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Pais" required onChange={handleChange}/>
					{errorsForms.pais && <p className="absolute w-full text-red-500 text-xs">{errorsForms.pais}</p>}
				</div>	

				<div className=" relative">
					<label htmlFor="direccion" className='block mb-2'>Dirección</label>
					<input type="text" id="direccion" name="direccion" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Dirección" required onChange={handleChange}/>				
					{errorsForms.direccion && <p className="absolute w-full text-red-500 text-xs">{errorsForms.direccion}</p>}
				</div>

				<div className="flex gap-4 mobile:flex-col mobile:gap-0 mb-10 relative">
					<div className="w-1/2 mobile:w-full relative">
						<label htmlFor="password" className='block mb-2'>Contraseña</label>
						<input type="password" id="password" name="password" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Contraseña" required onChange={handleChange}/>				
					</div>
					<div className="w-1/2 mobile:w-full relative">	
						<label htmlFor="repeatPassword" className='block mb-2'>Repetir Contraseña</label>
						<input type="password" id="repeatPassword" name="repeatPassword" className='w-full border-solid border rounded-lg px-2 py-2' placeholder="Repetir Contraseña" required onChange={handleChange}/>				
						{errorsForms.repeatPassword && <p className="absolute w-full text-red-500 text-xs">{errorsForms.repeatPassword}</p>}
					</div>
					{errorsForms['autenticacion.password'] &&  <p className="absolute w-full text-red-500 text-xs top-20">{errorsForms['autenticacion.password']}</p>}
				</div>


				<div className="flex w-full gap-4">
					<button className="w-1/2 bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg" type="submit">REGISTRAR</button>
					<button className="w-1/2 bg-[#2C2C2C] py-2 rounded-lg text-white hover:shadow-lg" onClick={cancelFoo}>CANCELAR</button>
				</div>
				{errorsForms.message && <p className="text-red-500 text-xs mt-2 absolute bottom-4">{errorsForms.message}</p>}
			</form>
		</div>
	)
}
export default RegisterForm
