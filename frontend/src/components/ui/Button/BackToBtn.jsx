import { Link } from "react-router-dom"

const BackToBtn = ({link, text}) => {
  return (
    <Link to={link} className="w-[400px] m-auto py-2 px-4 block text-center mb-4 border border-solid rounded-2xl bg-primary text-white hover:shadow-lg">{text}</Link>
  )
}
export default BackToBtn