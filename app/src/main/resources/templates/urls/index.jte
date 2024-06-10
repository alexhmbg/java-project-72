@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.util.NamedRoutes
@import java.time.format.DateTimeFormatter
@param UrlsPage page

!{var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");}
!{var pages = page.getPages();}
!{var currentPage = page.getCurrentPage();}
!{var urls = page.getUrls();}
!{var urlChecks = page.getUrlChecks();}

@template.layout.page(
page = page,
content = @`
    <section>
        <div class="container-lg mt-5">
            <h1>Сайты</h1>

            <table class="table table-bordered table-hover mt-3">
                <thead>
                <tr>
                    <th class="col-1">ID</th>
                    <th>Имя</th>
                    <th class="col-2">Последняя проверка</th>
                    <th class="col-1">Код ответа</th>
                </tr>
                </thead>
                <tbody>
                @for(var url: urls)
                    <tr>
                        <td>${url.getId()}</td>
                        <td>
                            <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>
                        </td>
                        @if(urlChecks.containsKey(url.getId()))
                            <td>
                                ${urlChecks.get(url.getId()).getCreatedAt().toLocalDateTime().format(formatter)}
                            </td>
                            <td>
                                ${urlChecks.get(url.getId()).getStatusCode()}
                            </td>
                        @else
                            <td></td>
                            <td></td>
                        @endif
                    </tr>
                @endfor
                </tbody>
            </table>

            @if(pages.size() > 0)
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center mt-5">
                        <li class='${"page-item" + (currentPage <= 1 ? " disabled" : "")}'>
                            <a class="page-link" href="${NamedRoutes.urlsPath()}?page=${currentPage - 1}">Previous</a>
                        </li>
                        @for(var pageNumber : pages)
                            <li class='${"page-item" + (currentPage == pageNumber ? " active" : "")}'>
                                <a class="page-link" href="${NamedRoutes.urlsPath()}?page=${pageNumber}">${pageNumber}</a>
                            </li>
                        @endfor
                        <li class='${"page-item" + (currentPage >= pages.size() ? " disabled" : "")}'>
                            <a class="page-link" href="${NamedRoutes.urlsPath()}?page=${currentPage + 1}">Next</a>
                        </li>
                    </ul>
                </nav>
            @endif
        </div>
    </section>
`
)