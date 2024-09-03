import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import Home from './views/Home';
import PackageDetailView from './views/PackageDetailView';
import Contact from './views/Contact';
import PackageList from './views/PackageList';

function App() {


  return (
    <>
     <BrowserRouter>
       <Routes>
         <Route path="/" element={<Home/>} />
         <Route path='/PackageDetailView/:id' element={<PackageDetailView/>}/>
         <Route path="/packagelist" element={<PackageList/>} />
         <Route path="/contact" element={<Contact/>} />
       </Routes>
     </BrowserRouter>
    </>
  )
}

export default App
