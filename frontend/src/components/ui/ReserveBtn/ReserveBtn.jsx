import { Link } from 'react-router-dom'
import './ReserveBtn.css'
const ReserveBtn = () => {
  return (
    <button className="w-[411px] mobile:w-auto mobile:mx-4 h-16 bg-primary rounded-[100px] text-white text-l" id='reserveBtn'>
        <Link to='/packages'>RESERVAR</Link>
    </button>
  )
}
export default ReserveBtn