import { useParams } from 'react-router-dom';
import packages from '../db/packages.json'
import { useEffect, useState } from 'react';
import Loader from '../components/ui/Loader/Loader';
import Footer from '../components/ui/Footer/Footer';

const findObject = (arr, id) => {
    const objt = arr.find(arr => arr.id === id)
    if (!objt) return null
    return objt    
}

const PackageDetailView = () => {
    const { id } = useParams();  
    const [loading, setLoading] = useState(true)
    
    const [setselectedPackage, setSelectedPackage] = useState(null)
    
    useEffect(() => {
        //asincronia para simular llamada a api
        setTimeout(() => {
            setSelectedPackage(findObject(packages, id))
            setLoading(false)            
      }, 1000)
    })

    return (
        <>
            <main className='min-h-screen w-screen flex flex-col items-center justify-center'>
                {
                    loading ?
                        <Loader/> :                    
                        setselectedPackage ? 
                        <>
                            {/* Package Details */}
                            <div className="w-[1200px] notebook:w-full  flex flex-wrap mobile:flex-col mobile:flex-nowrap mobile:items-center justify-center my-6 mobile:px-6">
                                <img src={setselectedPackage["link to photo"]} alt="imagen del paquete" className='w-1/2 mobile:w-full py-4 pr-4 pl-8 mobile:pr-0 mobile:pl-0 object-cover'/>
                                <div className='w-1/2 mobile:w-full py-4 pl-4 pr-8 mobile:pr-0 mobile:pl-0'>
                                    <h1 className='text-2xl font-bold mb-2'>{setselectedPackage.title}</h1>
                                    <div className='flex flex-wrap gap-2'>
                                        {setselectedPackage.tags.map((tag, index) => (
                                            <p key={index} className='mobile:text-sm bg-green-200 rounded-xl text-green-800 px-3 py-2 mobile:py-1 mobile:px-3'>{tag}</p>
                                        ))}
                                    </div>
                                    <h2 className='text-4xl font-bold my-2 '>${setselectedPackage.price} USD</h2>
                                    <h3 className='text-gray-500 mb-4'>{setselectedPackage.subtitle}</h3>
                                    <label htmlFor="persons" className='block mb-2'>Cantidad de pasajeros</label>
                                    <select name="persons" id="" className='w-1/2 border-solid border rounded-lg py-1 px-2 mb-4'>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                    <button className='w-full border-solid border border-gray-900 rounded-lg bg-primary text-white py-2 mb-4'>Comprar</button>
                                    <div className='border-solid border border-gray-200 rounded-lg p-2'>
                                        <h3 className='font-bold mb-1'>Descripción</h3>
                                        <p className='mobile:text-sm font-light'>{setselectedPackage.description}</p>
                                    </div>
                                </div>
                            </div>

                            {/* COMENTARIOS */}
                            <div className='w-full bg-[#f0e2d5] py-5 px-10 flex flex-col items-center justify-between'>
                                <h3 className='w-full text-2xl text-center font-bold mb-6 text-gray-900'>Comentarios</h3>
                                <div className='w-full flex tablet:flex-col items-center justify-center gap-5'>
                                    {setselectedPackage.reviews.map((review, index) => (
                                        <div key={index} className='w-[350px] notebook:w-[300px] mobile:w-[full] flex flex-wrap content-around justify-center border-solid border-2 rounded-lg bg-white p-3'>
                                            <div className='flex flex-wrap content-start justify-start w-full'>
                                                {[...Array(review.rating)].map((star, index) => (                                       
                                                    <img src="../Icons/star.svg" alt="estrella" className='w-5 opacity-90 mb-5' key={index}/>
                                                ))}
                                            </div>
                                            <div className='flex flex-wrap content-start justify-start w-full mb-4'>
                                                <p className='text-gray-500 mobile:text-sm'>{review.comment}</p>
                                            </div>
                                            <div className='flex flex-wrap content-center justify-start w-full'>
                                                <img src={review.thumbnail} alt="thumbnail" className='w-16 h-16 rounded-full object-cover' />
                                                <div className=' ml-4 h-16 flex flex-wrap flex-col content-center justify-center'>
                                                    <p className='text-gray-700 font-bold'>{review.name}</p>
                                                    <p className='text-gray-500'>{review.date}</p>
                                                </div>
                                            </div>
                                        </div>                                    
                                    ))}
                                </div>
                            </div>
                        </> :
                        <h1 className='text-3xl text-gray-900 font-bold'>Paquete no encontrado</h1>              
                }
            </main>   
            <Footer/>
        </>
    )
}

export default PackageDetailView