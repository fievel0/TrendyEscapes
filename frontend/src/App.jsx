import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import Home from './views/Home';
import PackageDetailView from './views/PackageDetailView';

function App() {


  return (
    <>
     <BrowserRouter>
       <Routes>
         <Route path="/" element={<Home/>} />
         <Route path='/PackageDetailView/:id' element={<PackageDetailView/>}/>
       </Routes>
     </BrowserRouter>
    </>
  )
}

export default App
