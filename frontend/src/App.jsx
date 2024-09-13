import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import Home from './views/Home';
import Contact from './views/Contact';
import Packages from './views/Packages';
import Detail from './views/Detail';
import Footer from './components/ui/Footer/Footer';
import Navbar from './components/ui/Navbar/Navbar';
import { UserProvider } from './context/userContext';

function App() {


	return (
		<>
			<UserProvider>
				<BrowserRouter>
					<Navbar />
					<Routes>
						<Route path="/" element={<Home />} />
						<Route path="/packages" element={<Packages />} />
						<Route path='/packages/:id' element={<Detail />} />
						<Route path="/contact" element={<Contact />} />
					</Routes>
					<Footer />
				</BrowserRouter>
			</UserProvider>
		</>
	)
}

export default App
