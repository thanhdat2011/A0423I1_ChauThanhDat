import Footer from "./Footer";
import Header from "./Header";
import {useLocation} from "react-router-dom";
import '../layouts/FooterExtra';
import FooterExtra from "./FooterExtra";
import '../css/defaultLayout.css';


function DefaultLayout ({children})  {
    const location = useLocation();

    return (
        <>
            {location.pathname === "/" || location.pathname === "/login"
                ?
                <div className={"overflow-hidden w-full h-auto "}>
                    <Header/>
                    {children}
                    <Footer/>
                </div>
                :
                <div className=" h-full ">
                    <div className=" h-screen custom-grid grid-rows-3">
                        <div className="">
                            <Header/>
                        </div>
                        <div className="mx-10 mt-5">
                            <FooterExtra nameLocation={location.pathname}/>
                            <div className="h-auto mt-10">
                                {children}
                            </div>
                        </div>
                    </div>
                </div>
            }

        </>
    )
}

export default DefaultLayout;