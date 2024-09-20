import { useState } from "react";
import { Link } from "react-router-dom";

const Search = () => {
  const [pais, setPais] = useState(null);

  const handlePais = (e) => {
    setPais(e.target.value);
  };

  return (
    <div className="bg-white h-16 mx-auto mobile:h-14 w-[411px] mobile:w-auto mobile:mx-4 px-5 rounded-2xl flex items-center justify-between">
      {/* <input type="text" className="bg-white focus:bg-white focus:outline-none mobile:w-[180px]" /> */}
      <select name="pais" id="pais" className="w-full" onChange={handlePais}>
        <option value="Selecciona un País" disabled selected>
          Selecciona un País
        </option>
        <option value="United%20States">United States</option>
        <option value="Brazil">Brazil</option>
        <option value="Spain">Spain</option>
        <option value="France">France</option>
        <option value="Maldives">Maldives</option>
        <option value="Morocco">Morocco</option>
        <option value="Mexico">Mexico</option>
        <option value="Chile">Chile</option>
        <option value="Japan">Japan</option>
        <option value="Ecuador">Ecuador</option>
        <option value="Tanzania">Tanzania</option>
        <option value="Thailand">Thailand</option>
        <option value="Greece">Greece</option>
        <option value="Italy">Italy</option>
        <option value="Egypt">Egypt</option>
        <option value="Switzerland">Switzerland</option>
        <option value="South%20Africa">South Africa</option>
      </select>
      {pais ? (
        <Link
          to={`/search/${pais}`}
          className="h-14 w-14 mobile:h-10 mobile:w-10 bg-primary rounded-2xl text-3xl flex justify-center items-center pb-[6px]"
        >
          <img
            src="/Images/search.svg"
            alt="search icon"
            className="p-2 pt-3 object-contain"
          />
        </Link>
      ) : (
        <button className="h-14 w-14 mobile:h-10 mobile:w-10 bg-primary rounded-2xl text-3xl flex justify-center items-center pb-[6px]">
          <img
            src="/Images/search.svg"
            alt="search icon"
            className="p-2 pt-3 object-contain"
          />
        </button>
      )}
    </div>
  );
};
export default Search;
