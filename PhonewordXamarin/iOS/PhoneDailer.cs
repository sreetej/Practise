using Foundation;
using UIKit;
using Xamarin.Forms;
using PhonewordXamarin.iOS;


[assembly: Dependency(typeof(PhoneDailer))]
namespace PhonewordXamarin.iOS
{
	public class PhoneDailer : IDailer
	{
			
		public bool Dial(string number)
		{
			return UIApplication.SharedApplication.OpenUrl(
				new NSUrl("tel:" + number));
		}
	}
}
