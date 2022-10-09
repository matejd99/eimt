import React from "react";
import { useNavigate } from "react-router-dom";

const CreateCountry = (props) => {
  const navigate = useNavigate();
  const [formData, updateFormData] = React.useState({
    name: "",
    continent: "",
  });

  const handleChange = (e) => {
    updateFormData({
      ...formData,
      [e.target.name]: e.target.value.trim(),
    });
  };

  const onSubmit = (e) => {
    e.preventDefault();
    const name = formData.name;
    const continent = formData.continent;

    props.onSubmit(name, continent).then(() => {
      navigate("/countries");
    });
  };

  return (
    <form onSubmit={onSubmit}>
      <div>
        <label>Name</label>
        <input type="text" name="name" onChange={handleChange}></input>
      </div>
      <div>
        <label>Continent</label>
        <input type="text" name="continent" onChange={handleChange}></input>
      </div>
      <div>
        <input type="submit"></input>
      </div>
    </form>
  );
};

export default CreateCountry;
