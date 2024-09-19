
import SearchBox from "../components/ui/SearchBox/SearchBox";


const Home = () => {
  

  return (
    <main
      className="h-screen text-black flex flex-wrap flex-col content-center justify-around"
      id="landPage"
    >
      <SearchBox />
      <div className="w-full flex flex-col content-center justify-center">
        <h1 className="w-full text-6xl mobile:text-2xl text-center text-white">
          Es hora de tu
          <br />
          <span className="text-8xl mobile:text-4xl font-bold">próxima aventura</span>
        </h1>
        <p className="w-full text-2xl mobile:text-base text-center text-white">
          Déjanos planearlo por ti
        </p>
      </div>
      <p></p>
    </main>
  );
};

export default Home;
