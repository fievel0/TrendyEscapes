import { useLocation, useParams } from 'react-router-dom';
import packages from '../db/packages.json'
import { useEffect, useLayoutEffect, useState } from 'react';
import Loader from '../components/ui/Loader/Loader';
import PackageDetail from '../components/viajes/PackageDetail';
import Comments from '../components/viajes/Comments';
import PayForm from '../components/forms/PayForm';
import PaymentModal from '../components/ui/PaymentModal/PaymentModal';
import BackToBtn from '../components/ui/Button/BackToBtn';

const findObject = (arr, id) => {
    const objt = arr.find(arr => arr.id === id)
    if (!objt) return null
    return objt    
}

const Detail = () => {
    const { id } = useParams();  
    const [loading, setLoading] = useState(true)
    const [payForm, setPayForm] = useState(false)
    const [payment, setPayment] = useState(false)
    
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

    const onPay = () => {
        setPayForm(true)
    }

    const closePayForm = () => {
        setPayForm(false)
    }

    const onPayment = (user) => {
        console.log("🚀 ~ onPayment ~ user:", user)       
        setPayment(true)
    }



    return (
        <>
            <main className='min-h-screen w-screen flex flex-col items-center justify-center'>
                {
                    loading ?
                        <Loader/> :                    
                        setselectedPackage ? 
                        <>
                            {/* Package Details */}
                            <PackageDetail pkgd={setselectedPackage} onPay={onPay}/>
                            

                            {/* COMENTARIOS */}
                            <Comments pkgd={setselectedPackage}/>
                            
                        </> :
                        <h1 className='text-3xl text-gray-900 font-bold'>Paquete no encontrado</h1>              
                }
            </main>  
            <BackToBtn link="/packages" text='Volver a paquetes'/>
            {payForm && <PayForm closePayForm={closePayForm} onPayment={onPayment}/>}
            {payment && <PaymentModal/>}
        </>
    )
}

export default Detail