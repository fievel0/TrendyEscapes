import { useEffect, useState } from 'react'
import PackageCard from '../viajes/PackageCard';
import CardSkeleton from '../skeletons/CardSkeleton/CardSkeleton';
import { BASEURL } from '../../config/config';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Search from '../ui/Search/Search';

const PackageList = () => {
    const [loading, setLoading] = useState(true)
    const [pkgs, setPkgs] = useState(null)
    const { pais } = useParams();

    useEffect(() => {
        if (!pais) {
            axios.get(`${BASEURL}/paquetes`)
            .then((res) => {
                setPkgs(res.data.content)
                setLoading(false)
                console.log("🚀 ~ .then ~ res:", res.data.content)
                console.log("🚀 ~ .then ~ pkgs:", pkgs)
            }) 
        } else {
        axios.get(`${BASEURL}/paquetes?criteria=pais&value=${pais}`)        
        .then((res) => {
            setPkgs(res.data.content)
            setLoading(false)
            console.log("🚀 ~ .then ~ res:", res.data.content)
            console.log("🚀 ~ .then ~ pkgs:", pkgs)
        })  }      
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [pais])

  return (   
    <main className="flex flex-wrap justify-center gap-4 py-4 mb-4 bg-secundary">
        
        <div className='flex flex-col justify-center gap-4 py-4 mb-4 bg-secundary'>
            <Search/>


            <div className='flex flex-wrap justify-center gap-4 py-4 mb-4'>
            {loading ?
                Array.from({length: 5}, (_, i) => <CardSkeleton key={i} />) :

                pkgs.map((pkg) => (
                    <PackageCard key={pkg.id} packageData={pkg} />
                ))}
            </div> 
        </div>
                  
    </main>
  )
}
export default PackageList