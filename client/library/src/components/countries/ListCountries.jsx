const ListCountries = (props) => {
  return (
    <div>
      <ul>
        {props.countries.map((c) => {
          return (
            <li key={c.id}>
              {c.name} - {c.continent}
            </li>
          );
        })}
      </ul>
      <a href="/countries/create">Create country</a>
    </div>
  );
};

export default ListCountries;
