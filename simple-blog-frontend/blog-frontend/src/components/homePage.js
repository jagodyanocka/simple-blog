import React, { useState, useEffect } from 'react'
import BlogInput from './blogInput'
import PostView from './PostView';
import Thoughtlist from './thoughtlist'
import './homePage.css'

function HomePage() {
const [thoughts, setThoughts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/all")
    .then(response => response.json())
    .then(data => setThoughts(data))
  },[]);

  const [thoughtView, setThoughtView] = useState({
    id: ""
  })

  const viewThought = (id) => {
    setThoughtView({id})
  }

  const deletePost = (thoughtId) => {
    fetch('http://localhost:8080/api/' + thoughtId, { method: 'DELETE' })
    .then(() => {
        const filteredThoughts = thoughts.filter(thought => thought.id !== thoughtId)
        setThoughts(filteredThoughts)
    })
  }

  const createPost = (thought) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(thought) 
    };
    
    fetch('http://localhost:8080/api', requestOptions)
    .then(response => response.json())
    .then(data => setThoughts([data, ...thoughts]))
  }

  const showContainer = () => {
    if (thoughtView.id === "") {
        return (
            <>
                <BlogInput createPostFn={createPost}></BlogInput>
            </>
        )
    }
    return (
            <PostView deleteThoughtFn={deletePost} viewThoughtFn={viewThought} postId={thoughtView.id}></PostView>
        )
  }

  return (
    <>
        <div className='head'>
          <h1 className='headerHome'>
            Simple Blog.
          </h1>
          </div>
        <div className='homepagecontainter'>
            {showContainer()}
            <Thoughtlist viewThoughtFn={viewThought} thoughtsList={thoughts}></Thoughtlist>
        </div>
    </>
    
  )
}

export default HomePage