
import { useLocation } from "react-router-dom";
import BackToBtn from "../components/ui/Button/BackToBtn";
import PackageList from "../components/viajes/PackageList";
import { useLayoutEffect } from "react";

const Search = () => {


	const location = useLocation();
	useLayoutEffect(() => {
		document.documentElement.scrollTo(0, 0);
	}, [location.pathname]);
	
	return (
		<>
			<PackageList />
			<BackToBtn link="/" text="Volver a Home" />
		</>
	);
};


export default Search;
