import React, {Component} from "react";

class ExpandContent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isExpand: false,
            buttonText : 'Expand Content'
        }
    }

    handle() {
        this.setState({
            isExpand: !this.state.isExpand,
            buttonText : (this.state.isExpand ? 'Expand' : 'Collapse') + ' Content'
        })
    }

    render() {
        return (
            <>
                <h1>Conditional Rendering</h1>
                <button type="submit" onClick={() => this.handle()}>{this.state.buttonText}</button>
                <div style={{
                    display : this.state.isExpand ? "block" : "none"
                }}>
                    <p className="intro">Tại sao pure function lại quan trọng trong JavaScript ?</p>
                    <div>
                        Tại sao pure function lại quan trọng trong JavaScript
                        Pure functions được sử dụng nhiều trong lập trình hàm.
                        Những thư viện JS như ReactJS và Redux sử dụng pure function.
                        Bạn cũng có thể gặp chúng ở bất kỳ đâu tuy nhiên không phải tất cả các hàm đều cần thiết phải pure.
                        Một yếu tố khác cũng khuyến khích bạn viết pure functions khi có thể đó là khoản testing và refactoring.
                        Đặc tính luôn trả về một kết quả với cùng một đầu vào giúp cho việc test trở nên dễ dàng hơn bao giờ hết.
                        Trong khi đó, đặc tính không làm ảnh hưởng đến môi trường bên ngoài cũng giúp việc refactor code thuận lợi hơn
                        bởi vì bạn luôn chắc chắn rằng những thay đổi bên trong pure function sẽ chẳng phương hại gì đến những phần code khác của bạn.
                        Từ đây có thể thấy việc sử dụng pure function sẽ giúp cải thiện chất lượng code của bạn, giúp code clean hơn và hạn chế bug đáng kể.
                    </div>
                </div>
            </>
        )
    }
}

export default ExpandContent