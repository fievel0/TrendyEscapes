const Comments = ({pkgd}) => {
  return (
    <div className='w-full bg-[#f0e2d5] py-5 px-10 flex flex-col items-center justify-between mb-4'>
        <h3 className='w-full text-2xl text-center font-bold mb-6 text-gray-900'>Comentarios</h3>
        <div className='w-full flex tablet:flex-col items-center justify-center gap-5'>
            {pkgd.reviews.map((review, index) => (
                <div key={index} className='w-[350px] notebook:w-[300px] mobile:w-[full] flex flex-wrap content-around justify-center border-solid border-2 rounded-lg bg-white p-3'>
                    <div className='flex flex-wrap content-start justify-start w-full'>
                        {[...Array(review.rating)].map((star, index) => (                                       
                            <img src="../Icons/star.svg" alt="estrella" className='w-5 opacity-90 mb-5' key={index}/>
                        ))}
                    </div>
                    <div className='flex flex-wrap content-start justify-start w-full mb-4'>
                        <p className='text-gray-500 mobile:text-sm'>{review.comment}</p>
                    </div>
                    <div className='flex flex-wrap content-center justify-start w-full'>
                        <img src={review.thumbnail} alt="thumbnail" className='w-16 h-16 rounded-full object-cover' />
                        <div className=' ml-4 h-16 flex flex-wrap flex-col content-center justify-center'>
                            <p className='text-gray-700 font-bold'>{review.name}</p>
                            <p className='text-gray-500'>{review.date}</p>
                        </div>
                    </div>
                </div>                                    
            ))}
        </div>
    </div>
  )
}

export default Comments