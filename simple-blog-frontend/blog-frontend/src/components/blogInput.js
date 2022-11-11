import React, {useState} from 'react'
import './blogInput.css'

export default function BlogInput({createPostFn}) {
    const [input, setInput] = useState({
        title: "",
        body: ""
    });

    const handleInputChange = e => {
        setInput({ ...input, [e.target.name]: e.target.value });
    };

    const handleAddClick = e => {
        e.preventDefault();
        if(input.title.trim()) {
            createPostFn(input);
            setInput({...input, title: "", body: ""});
        };
    }

  return (
    <div>
    <form className="inputForm" onSubmit={handleAddClick}>
       <label className='titleOfInput' htmlFor="title">Title: </label>
       <input className="inputField" name="title" type="text" value={input.title} placeholder="Add title..." onChange={handleInputChange}/>
       <label className='body' htmlFor="body">Your post </label>
       <textarea rows='25' className="inputField" name="body" type="text" value={input.body} placeholder="Write here... " onChange={handleInputChange}/>
       <button className='create' id="btnCreate">Publish</button>
    </form>
   </div>
  )
}
