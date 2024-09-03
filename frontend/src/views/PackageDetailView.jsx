import { useLocation, useParams } from 'react-router-dom';
import packages from '../db/packages.json'
import { useEffect, useLayoutEffect, useState } from 'react';
import Loader from '../components/ui/Loader/Loader';
import Footer from '../components/ui/Footer/Footer';
import PackageDetail from '../components/viajes/PackageDetail';
import Comments from '../components/viajes/Comments';

const findObject = (arr, id) => {
    const objt = arr.find(arr => arr.id === id)
    if (!objt) return null
    return objt    
}

const PackageDetailView = () => {
    const { id } = useParams();  
    const [loading, setLoading] = useState(true)
    
    const [setselectedPackage, setSelectedPackage] = useState(null)

    const location = useLocation();
        useLayoutEffect(() => {
            document.documentElement.scrollTo(0, 0);
        }, [location.pathname]);
    
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
                            <PackageDetail pkgd={setselectedPackage}/>
                            

                            {/* COMENTARIOS */}
                            <Comments pkgd={setselectedPackage}/>
                            
                        </> :
                        <h1 className='text-3xl text-gray-900 font-bold'>Paquete no encontrado</h1>              
                }
            </main>   
            <Footer/>
        </>
    )
}

export default PackageDetailView