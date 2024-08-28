const SearchBox = () => {
  return (
   
    <div className="bg-white h-20 w-[411px] px-5 rounded-3xl flex flex-wrap content-around justify-between">
        <img src="./Images/search.svg" alt="search icon"/>
        <input type="text" className="bg-white focus:bg-white focus:outline-none" />
        <button className="h-14 w-14 bg-primary rounded-2xl text-3xl flex flex-wrap justify-center items-center pb-[6px]">+</button>
    </div>
   
  )
}
export default SearchBox