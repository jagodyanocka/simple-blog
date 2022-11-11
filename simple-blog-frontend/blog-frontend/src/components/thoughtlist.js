import BlogPost from './BlogPost';
import './thoughtlist.css'

export default function Thoughtlist({ viewThoughtFn, thoughtsList }) {
   
    const showThoughts = () => {
        const listOfThoughts = thoughtsList.map(thought => (
            <BlogPost viewThoughtFn={viewThoughtFn} key={thought.id} thoughtObj={thought} />
        ))
        return listOfThoughts;
    }
  return (
    <div className='listRecents'>
      <h3>Recents: </h3>
      {showThoughts()}
    </div>
  )
}
