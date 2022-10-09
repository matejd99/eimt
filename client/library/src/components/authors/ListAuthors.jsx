const ListAuthors = (props) => {
  return (
    <div>
      <ul>
        {props.authors.map((a) => {
          return (
            <li key={a.id}>
              {a.name} - {a.surname} - {a.country.name}
            </li>
          );
        })}
      </ul>
      <a href="/authors/create">Create author</a>
    </div>
  );
};

export default ListAuthors;
