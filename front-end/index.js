import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import { ButtonToolbar,Button } from 'react-bootstrap';

class FlavorForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
	  
fetch('http://localhost:8080/accountbalance?id='+this.state.value).then(response =>  response.json()).then(data => {console.log(data.content);  alert('You have: $' + data.content + ' in the account ' + this.state.value ); });

	   event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
 Retrieve your bank balance:
          <select value={this.state.value} onChange={this.handleChange}>
		     <option value="0"></option>
            <option value="123456789">123-456-789</option>
            <option value="789456123">789-456-123</option>
          </select>
		  <div>   </div>
        </label>

  	  <div>   </div>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

ReactDOM.render(
  <FlavorForm />,
  document.getElementById('root')
);