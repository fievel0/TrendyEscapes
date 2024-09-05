
import { useLocation } from "react-router-dom";
import BackToBtn from "../components/ui/Button/BackToBtn";
import PackageList from "../components/viajes/PackageList";
import { useLayoutEffect } from "react";
import Navbar from "../components/ui/Navbar";

const Packages = () => {

	const location = useLocation();
	useLayoutEffect(() => {
		document.documentElement.scrollTo(0, 0);
	}, [location.pathname]);
	
	return (
		<>
    <Navbar />
			<PackageList />
			<BackToBtn link="/" text="Volver a Home" />
		</>
	);
};


export default Packages;
