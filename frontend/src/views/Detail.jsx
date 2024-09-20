import { useLocation, useNavigate, useParams } from 'react-router-dom';
import { useEffect, useLayoutEffect, useState } from 'react';
import Loader from '../components/ui/Loader/Loader';
import PackageDetail from '../components/viajes/PackageDetail';
import Comments from '../components/viajes/Comments';
import PayForm from '../components/forms/PayForm';
import PaymentModal from '../components/ui/PaymentModal/PaymentModal';
import { BASEURL } from '../config/config';
import axios from 'axios';
import packages from '../db/packages.json'


const Detail = () => {
    const navigate = useNavigate();
    const [cost, setCost] = useState(0)
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
        axios.get(`${BASEURL}/paquetes/${id}`)
        .then((res) => {
            console.log("🚀 ~ .then ~ res:", res)
            setSelectedPackage(res.data)
            setLoading(false)
        })     
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    const hangleCost = (cost) => {
        setCost(cost)   
    }

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
                            <PackageDetail pkgd={setselectedPackage} onPay={onPay}  hangleCost={hangleCost}/>
                            

                            {/* COMENTARIOS */}
                            <Comments pkgd={packages[0]}/>
                            
                        </> :
                        <h1 className='text-3xl text-gray-900 font-bold'>Paquete no encontrado</h1>              
                }
            </main>  
            <button className="w-[400px] mobile:w-[300px] m-auto py-2 px-4 block text-center mb-4 border border-solid rounded-2xl bg-primary text-white hover:shadow-lg" onClick={() => navigate(-1)}>Volver a paquetes</button>
            {/* <BackToBtn link="/packages" text='Volver a paquetes'/> */}
            {payForm && <PayForm closePayForm={closePayForm} onPayment={onPayment} cost={cost}/>}
            {payment && <PaymentModal/>}
        </>
    )
}

export default Detail