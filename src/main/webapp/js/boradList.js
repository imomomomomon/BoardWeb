let printList = function (jsondata) {
    let div_list_group = document.getElementById("list-group");
    {
        let a_list_group_item = document.createElement('a');
        a_list_group_item.setAttribute("href","javascript:activceGoInfo("+jsondata.no+")");
        a_list_group_item.setAttribute("class","list-group-item");
        div_list_group.appendChild(a_list_group_item);
        {
            let div_board_title = document.createElement('div');
            div_board_title.setAttribute("class","board-title");
            a_list_group_item.appendChild(div_board_title);
            {
                let span_board_category = document.createElement('span');
                span_board_category.setAttribute("class","board-category");
                div_board_title.appendChild(span_board_category);
                span_board_category.innerHTML = jsondata.category;

                let span_board_title = document.createElement('span');
                div_board_title.appendChild(span_board_title);
                span_board_title.innerHTML = '['+jsondata.title+']';
            }
            let div_board_meta = document.createElement('div');
            div_board_meta.setAttribute("class","board-meta");
            div_board_meta.setAttribute("style","font-weight: 400; font-size: 1.2rem; color: #404040")
            a_list_group_item.appendChild(div_board_meta);
            {
                let p_meta = document.createElement('p');
                div_board_meta.appendChild(p_meta);
                {
                    let i_meta = [];
                    for(let i = 0; i < 3; i++){
                        i_meta[i] = document.createElement('i');
                        div_board_meta.appendChild(i_meta[i]);
                    }
                    i_meta[0].setAttribute("class","glyphicon glyphicon-user");
                    i_meta[0].innerHTML = jsondata.writer;
                    i_meta[1].setAttribute("class","glyphicon glyphicon-ok");
                    i_meta[1].innerHTML = jsondata.hit;
                    i_meta[2].setAttribute("class","glyphicon glyphicon-time");
                    i_meta[2].innerHTML = jsondata.regdate;
                }
            }
        }
    }
}

let printPageNum = function (cur,start,end) {
    let ul_pagination = document.getElementById("pagination");
    {
        //First
        let li_start = document.createElement('li');
        ul_pagination.appendChild(li_start);
        {
            let a = document.createElement('a');
            a.setAttribute("href","javascript:btnIncrease(0)");
            a.innerHTML = "<";
            li_start.appendChild(a);
        }
        //Num
        for (let i = start; i <=end; i++) {
            let li = document.createElement('li');
            if(i == cur) {
                li.setAttribute("class","active");
                li.setAttribute("id","btn_pagingActive");
            }
            ul_pagination.appendChild(li);
            {
                let a = document.createElement('a');
                a.setAttribute("href","javascript:btn_selectList("+i+")");
                a.innerHTML = i;
                li.appendChild(a);
            }
        }
        //End
        let li_end = document.createElement('li');
        ul_pagination.appendChild(li_end);
        {
            let a = document.createElement('a');
            a.setAttribute("href","javascript:btnIncrease(1)");
            a.innerHTML = ">";
            li_end.appendChild(a);
        }
    }
}
let printCatergoryList = function (arr) {
        let select_section_category = document.getElementById("section_category");
        {
            let option = document.createElement('option');
            select_section_category.appendChild(option);
            option.innerHTML = 'All';
        }
        for (let i = 1; i < arr.length; i++) {
            let option = document.createElement('option');
            select_section_category.appendChild(option);
            option.innerHTML = arr[i];
        }
        {
            let option = document.createElement('option');
            select_section_category.appendChild(option);
            option.innerHTML = arr[0];
        }
}