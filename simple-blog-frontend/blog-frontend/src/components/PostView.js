import React, { useEffect, useState } from 'react'
import './PostView.css'

export default function PostView({deleteThoughtFn, viewThoughtFn, postId}) {
    const [singleThought, setSingleThought] = useState({})

    const handleBackButton = () => {
        viewThoughtFn("")
    }

    const handleDeleteButton = () => {
        deleteThoughtFn(postId)
        viewThoughtFn("")
    }
    
    useEffect(() => {
        fetch('http://localhost:8080/api/' + postId)
        .then(response => response.json())
        .then(data => setSingleThought(data))
    })

  return (
   <>
    <div className='postview'>
        <h1>{singleThought.title}</h1>
        <p>{singleThought.body}</p>
        <div className='buttoncontainer'>
            <div className='buttons' >
                <button onClick={handleBackButton}>Back</button>
                <button onClick={handleDeleteButton}>Delete</button>
            </div>
        </div>
        
    </div>
  
   </>
  )
}
