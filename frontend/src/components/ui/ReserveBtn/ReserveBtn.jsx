import { Link } from 'react-router-dom'
import './ReserveBtn.css'
const ReserveBtn = () => {
  return (
    <button className="w-[411px] h-16 bg-primary rounded-[100px] text-white text-l shadow-inner" id='reserveBtn'>
        <Link to='/packagelist'>RESERVAR</Link>
    </button>
  )
}
export default ReserveBtn