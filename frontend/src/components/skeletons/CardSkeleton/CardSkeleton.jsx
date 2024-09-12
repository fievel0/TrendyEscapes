import '../skeletons.css'
const CardSkeleton = () => {
  return (
    <div className="w-96 rounded-2xl overflow-hidden shadow-lg bg-white border border-gray-300">
        <div className="flex flex-col w-full pt-4 px-4 mb-2">
            <div className="rounded-lg w-1/2 h-8 skeleton mb-4"></div>
            <div className="rounded-lg w-full h-[3rem] skeleton"></div>
        </div>
        
        <div className="w-full h-48 skeleton mb-4"></div>      
        <div className="w-[calc(100%-2rem)] mx-auto h-60 skeleton rounded-lg mb-4"></div>  
        <div className="rounded-lg w-1/2 h-8 skeleton ml-4 mb-4"></div>  

        
        <div className="px-6 pt-4 pb-2 flex items-center justify-end gap-1">
            <div className="rounded-lg w-1/3 h-8 skeleton"></div>
            <div className="rounded-lg w-1/3 h-8 skeleton"></div>
        </div>
    </div>
  )
}
export default CardSkeleton