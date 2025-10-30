//package br.com.serratec.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import br.com.serratec.dto.VendedorResponseDTO;
//import br.com.serratec.entity.Vendedor;
//import br.com.serratec.repository.VendedorRepository;
//
//@Service
//public class VendedorService {
//
//	
//	@Autowired
//	private VendedorRepository repository;
//	
//	public VendedorResponseDTO buscarCnpj (String cnpj) {
//		Optional<Vendedor> vendedor = repository.findyByCnpj(cnpj); 
//		if (vendedor.isPresent()) {
//			return new VendedorResponseDTO(vendedor.get().getCnpj(),vendedor.get().getAbertura(),vendedor.get().getSituacao(),
//					vendedor.get().getTipo(),vendedor.get().getNome(),vendedor.get().getFantasia(),vendedor.get().getLogradouro(),
//					vendedor.get().getNumero(),vendedor.get().getComplemento(),vendedor.get().getBairro(),vendedor.get().getLocalidade(),
//					vendedor.get().getUf());
//		}else {
//			RestTemplate rs = new RestTemplate();
//			String url = "https://receitaws.com.br/v1/cnpj/"+cnpj+"/json/";
//			Optional<Vendedor> enderecoViaCnpj = Optional.ofNullable(rs.getForObject(url, Vendedor.class));
//			
//			return null;
//			//if (vendedorViaCep.get().ge) {
//				
//			}
//		}
//	}
//}
