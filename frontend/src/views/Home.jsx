import ReserveBtn from "../components/ui/ReserveBtn/ReserveBtn"
import SearchBox from "../components/ui/SearchBox/SearchBox"

const Home = () => {
  return (
    <main className='h-screen text-black flex flex-wrap flex-col content-center justify-around' id='landPage'>
       <SearchBox/>
       <h1 className='text-base text-center text-white'>Es hora de tu<br/><span className='text-4xl'>próxima aventura</span></h1>
       <ReserveBtn/>
    </main>
  )
}

export default Home