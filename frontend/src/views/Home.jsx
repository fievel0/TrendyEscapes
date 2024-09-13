import { useContext, useEffect } from "react"
import ReserveBtn from "../components/ui/ReserveBtn/ReserveBtn"
import SearchBox from "../components/ui/SearchBox/SearchBox"
import UserContext from "../context/userContext"

const usermail = "eneas@gmail.com"
const userpass = 'Contrasena123*'


const Home = () => {
  const {loginFoo} = useContext(UserContext)

  useEffect(() => {
    loginFoo(usermail, userpass)
  }, [])



  return (
    <main className='h-screen text-black flex flex-wrap flex-col content-center justify-around' id='landPage'>
       <SearchBox/>
       <h1 className='text-base text-center text-white'>Es hora de tu<br/><span className='text-4xl'>próxima aventura</span></h1>
       <ReserveBtn/>
    </main>
  )
}

export default Home