import React from 'react'
import './BlogPost.css';

function BlogPost({ viewThoughtFn, thoughtObj }) {
 
const handleClick = (e) => {
    e.preventDefault()
    viewThoughtFn(thoughtObj.id)
}

  return (
    <div className='recents'>
        <a className='publishedAt' href='#' onClick={handleClick}>
            { thoughtObj.publishedAt }
        </a>
        <p className='title'>
            { thoughtObj.title }
        </p>
    </div>
  )
}

export default BlogPost