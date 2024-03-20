import logo from './logo.svg';
import './App.css';
import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebookF, faGoogle, faTwitter, faGithub } from '@fortawesome/free-brands-svg-icons';

function App() {
    return (
        <>
            <section className="text-center text-lg-start">
                <style>
                    {`
                      .cascading-right {
                        margin-right: -50px;
                      }
            
                      @media (max-width: 991.98px) {
                        .cascading-right {
                          margin-right: 0;
                        }
                      }
                    `}
                </style>


                <div className="container py-4">
                    <div className="row g-0 align-items-center">
                        <div className="col-lg-6 mb-5 mb-lg-0">
                            <div
                                className="card cascading-right"
                                style={{
                                    background: 'hsla(0, 0%, 100%, 0.55)',
                                    backdropFilter: 'blur(30px)',
                                }}
                            >
                                <div className="card-body p-5 shadow-5 text-center">
                                    <h2 className="fw-bold mb-5">Sign up now</h2>
                                    <form>
                                        {/* 2 column grid layout with text inputs for the first and last names */}
                                        <div className="row">
                                            <div className="col-md-6 mb-4">
                                                <div className="form-outline">
                                                    <input type="text" id="form3Example1" className="form-control" placeholder="First name" />
                                                    {/*<label className="form-label" htmlFor="form3Example1">First name</label>*/}
                                                </div>
                                            </div>
                                            <div className="col-md-6 mb-4">
                                                <div className="form-outline">
                                                    <input type="text" id="form3Example2" className="form-control" placeholder="Last name"/>
                                                    {/*<label className="form-label" htmlFor="form3Example2">Last name</label>*/}
                                                </div>
                                            </div>
                                        </div>

                                        <div className="form-outline mb-4">
                                            <input type="email" id="form3Example3" className="form-control" placeholder="Email address"/>
                                            {/*<label className="form-label" htmlFor="form3Example3">Email address</label>*/}
                                        </div>

                                        <div className="form-outline mb-4">
                                            <input type="password" id="form3Example4" className="form-control" placeholder="Password"/>
                                            {/*<label className="form-label" htmlFor="form3Example4">Password</label>*/}
                                        </div>

                                        {/* Checkbox */}
                                        <div className="form-check d-flex justify-content-center mb-4">
                                            <input className="form-check-input me-2" type="checkbox" value="" id="form2Example33" checked/>
                                            <label className="form-check-label" htmlFor="form2Example33">
                                                Subscribe to our newsletter
                                            </label>
                                        </div>

                                        {/* Submit button */}
                                        <button type="submit" className="btn btn-primary btn-block mb-4">
                                            Sign up
                                        </button>

                                        {/* Register buttons */}
                                        <div className="text-center">
                                            <p>or sign up with:</p>
                                            <button type="button" className="btn btn-link btn-floating mx-1">
                                                {/*<i className="fab fa-facebook-f"/>*/}
                                                <FontAwesomeIcon icon={faFacebookF} />
                                            </button>

                                            <button type="button" className="btn btn-link btn-floating mx-1">
                                                {/*<FontAwesomeIcon icon={faFacebookF} />*/}
                                                <FontAwesomeIcon icon={faGoogle} />
                                            </button>

                                            <button type="button" className="btn btn-link btn-floating mx-1">
                                                {/*<i className="fab fa-twitter"/>*/}
                                                <FontAwesomeIcon icon={faTwitter} />
                                            </button>

                                            <button type="button" className="btn btn-link btn-floating mx-1">
                                                {/*<i className="fab fa-github"/>*/}
                                                <FontAwesomeIcon icon={faGithub} />
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div className="col-lg-6 mb-5 mb-lg-0">
                            <img src="https://images.unsplash.com/photo-1535223289827-42f1e9919769?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                                 className="w-100 rounded-4 shadow-4" alt="" />
                        </div>
                    </div>
                </div>

            </section>
        </>

    );
}

export default App;
