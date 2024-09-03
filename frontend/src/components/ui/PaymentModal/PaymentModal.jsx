import { Link } from "react-router-dom"

const PaymentModal = () => {
  return (
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-65 backdrop-blur-sm z-[60] flex items-center justify-center p-4">
        <div className="flex flex-col w-[500px] bg-white p-10 rounded-lg shadow-md">
            <h3 className="text-lg font-bold text-center mb-4">Reserva realizada con éxito</h3>
            <button className="bg-gray-800 rounded-lg text-white py-2"><Link to='/'>Volver a Home</Link></button>
        </div>
    </div>
  )
}

export default PaymentModal