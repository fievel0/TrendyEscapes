const PackageDetail = ({pkgd, onPay, hangleCost}) => { 
    
    const handlePrice = (e) => {
        hangleCost(e.target.value * pkgd.costo)
    }
     
    return (
        <div className="w-[1200px] notebook:w-full  flex flex-wrap mobile:flex-col mobile:flex-nowrap mobile:items-center justify-center my-6 mobile:px-6">
            <img src={`/Images/packages${pkgd.foto}`} alt="imagen del paquete" className='w-1/2 mobile:w-full max-h-[500px] py-4 pr-4 pl-8 mobile:pr-0 mobile:pl-0 object-cover'/>
            <div className='w-1/2 mobile:w-full py-4 pl-4 pr-8 mobile:pr-0 mobile:pl-0'>
                <h1 className='text-2xl font-bold mb-2'>{pkgd.nombre}</h1>
                {/* <div className='flex flex-wrap gap-2'>
                    {pkgd.tags.map((tag, index) => (
                        <p key={index} className='mobile:text-sm bg-green-200 rounded-xl text-green-800 px-3 py-2 mobile:py-1 mobile:px-3'>{tag}</p>
                    ))}
                </div> */}
                <h2 className='text-4xl font-bold my-2 '>${pkgd.costo} USD</h2>
                <h3 className='text-gray-500 mb-4'>{pkgd.tipoPaquete}</h3>
                <div className="flex mobile:flex-col w-full gap-2">
                    <div className="flex flex-col w-1/2 mobile:w-full justify-between">
                        <label htmlFor="persons" className='block mb-2'>Cantidad de pasajeros</label>
                        <select name="persons" id="" className='w-full border-solid border rounded-lg py-1 px-2 mb-4' onChange={handlePrice} >
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <div className="flex flex-col w-1/2 mobile:w-full justify-between">
                        <label htmlFor="date" className='block mb-2'>Fecha de viaje</label>
                        <input type="date" name="date" id="date" className='w-full border-solid border rounded-lg py-1 px-2 mb-4'/>
                    </div>
                </div>
                <button className='w-full border-solid rounded-lg bg-primary text-white py-2 mb-4 hover:shadow-lg' onClick={onPay}>Comprar</button>
                <div className='border-solid border border-gray-200 rounded-lg p-2'>
                    <h3 className='font-bold mb-1'>Descripción</h3>
                    <p className='mobile:text-sm font-light'>{pkgd.descripcion}</p>
                </div>
            </div>
        </div>
    )
}

export default PackageDetail