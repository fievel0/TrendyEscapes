const PayForm = () => {

  const handleChange = (e) => {
    console.log(e.target.value)
  }
  return (
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50 backdrop-blur-sm z-50 flex items-center justify-center p-4">
        <form className="flex flex-col max-w-[500px] bg-white p-10 rounded-lg shadow-md">
            <legend className="font-bold text-2xl mb-4">Formulario de Pago</legend>
            <p className="text-[18px] mb-4">Total a pagar: $100</p>
            <div>
                <label htmlFor="name" className='block mb-2'>Nombre Completo</label>
                <input type="text" id="name" name='name' className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Nombre" onChange={handleChange}/>
            </div>

            <div>
                <label htmlFor="email" className='block mb-2'>Email</label>
                <input type="email" id="email" name="email" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Email" onChange={handleChange}/> 
            </div>

            <div className="flex w-full mobile:flex-col gap-x-4">
              <div className="w-1/2 mobile:w-full">
                <label htmlFor="card" className='block mb-2'>Número de Tarjeta</label>
                <input type="text" id="card" name="card" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Número de Tarjeta" onChange={handleChange}/>
              </div>

              <div className="w-1/2 mobile:w-full ">
                <label htmlFor="date" className='block mb-2 w-full'>Fecha de Vencimiento</label>
                <input type="date" id="date" name="date" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Fecha de Vencimiento" onChange={handleChange}/>
              </div>
            </div>

            <div className="flex w-full mobile:flex-col gap-x-4">
              <div className="w-1/2 mobile:w-full">
                <label htmlFor="moth" className='block mb-2'>Mes de Vencimiento</label>
                {/* select para 12 meses */}
                <select name="moth" id="moth" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' onChange={handleChange}>
                  {Array.from({length: 12}, (_, i) => i + 1).map((month) => (
                    <option key={month} value={month}>{month}</option>
                  ))}
                </select>
              </div>

              <div className="w-1/2 mobile:w-full">
                <label htmlFor="year" className='block mb-2'>Ano de Vencimiento</label>
                <select name="year" id="year" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' onChange={handleChange}>
                  {Array.from({length: 12}, (_, i) => new Date().getFullYear() + i).map((year) => (
                    <option key={year} value={year}>{year}</option>
                  ))}
                </select>                
              </div>
            </div>

            <div className="flex w-full gap-4">
              <button className="w-1/2 bg-[#57D788] py-2 rounded-lg text-white hover:shadow-md">PAGAR</button>
              <button className="w-1/2 bg-[#D7CC57] py-2 rounded-lg text-white hover:shadow-md">CANCELAR</button>
            </div>


        </form>

    </div>
  )
}

export default PayForm