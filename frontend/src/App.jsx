import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import Home from './views/Home';
import Contact from './views/Contact';
import Packages from './views/Packages';
import Detail from './views/Detail';
import Footer from './components/ui/Footer/Footer';

function App() {


  return (
    <>
     <BrowserRouter>
       <Routes>
         <Route path="/" element={<Home/>} />
         <Route path="/packages" element={<Packages/>} />
         <Route path='/packages/:id' element={<Detail/>}/>
         <Route path="/contact" element={<Contact/>} />
       </Routes>
       <Footer/>
     </BrowserRouter>
    </>
  )
}

export default App
