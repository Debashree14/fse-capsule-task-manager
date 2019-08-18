import React from 'react';
import { Col, Row, Button, Form, FormGroup, Label, Input, FormText,Container } from 'reactstrap';

export default class ViewTask extends React.Component {
  render() {
    const containerStyle={
          'paddingTop':'20px'
      }
    return (
      <Container style={containerStyle}>
      <Form>
        <Row form>
          <Col md={6}>
             <FormGroup >
          <Label for="taskLabel" sm={2}>Task :</Label>
          <Col sm={10}>
            <Input type="text" name="email" id="task" placeholder="" />
       </Col>
        </FormGroup>
          </Col>
          <Col md={6}>
            <FormGroup >
          <Label for="parentTaskLabel" sm={2}>Parent Task :</Label>
           <Col sm={10}>
            <Input type="text" name="parentTask" id="parentTask" placeholder="" />
          </Col>
        </FormGroup>
          </Col>
        </Row>
       
        <Row form style={containerStyle}>
          <Col md={3}>
             <FormGroup >
          <Label for="startDateLabel" sm={4}>Priority From:</Label>
          <Col sm={8}>
            <Input type="text" name="startDate" id="startDate" placeholder="" />
          </Col>
        </FormGroup>
          </Col>
         <Col md={3}>
             <FormGroup >
          <Label for="startDateLabel" sm={4}>Priority To:</Label>
          <Col sm={8}>
            <Input type="text" name="startDate" id="startDate" placeholder="" />
          </Col>
        </FormGroup>
          </Col>
          <Col md={3}>
             <FormGroup >
          <Label for="startDateLabel" sm={4}>Start Date:</Label>
          <Col sm={8}>
            <Input type="text" name="startDate" id="startDate" placeholder="" />
          </Col>
        </FormGroup>
          </Col>
          <Col md={3}>
             <FormGroup >
          <Label for="startDateLabel" sm={4}>End Date:</Label>
          <Col sm={8}>
            <Input type="text" name="startDate" id="startDate" placeholder="" />
          </Col>
        </FormGroup>
          </Col>
        </Row>
        
       
      </Form>
      </Container>
    );
  }
}